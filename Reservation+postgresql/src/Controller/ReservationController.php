<?php

namespace App\Controller;

use App\Entity\Reservation;
use App\Form\ReservationType;
use App\Repository\ReservationRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\JsonResponse;


#[Route('/reservation')]
class ReservationController extends AbstractController
{
    #[Route('/', name: 'app_reservation_index', methods: ['GET'])]
    public function index(ReservationRepository $reservationRepository): Response
    {
        return $this->render('reservation/index.html.twig', [
            'reservations' => $reservationRepository->findAll(),
        ]);
    }

    #[Route('/new', name: 'app_reservation_new', methods: ['GET', 'POST'])]
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $reservation = new Reservation();
        $form = $this->createForm(ReservationType::class, $reservation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($reservation);
            $entityManager->flush();

            return $this->redirectToRoute('app_reservation_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('reservation/new.html.twig', [
            'reservation' => $reservation,
            'form' => $form,
        ]);
    }

    #[Route('/{id}', name: 'app_reservation_show', methods: ['GET'])]
    public function show(Reservation $reservation): Response
    {
        return $this->render('reservation/show.html.twig', [
            'reservation' => $reservation,
        ]);
    }

    #[Route('/{id}/edit', name: 'app_reservation_edit', methods: ['GET', 'POST'])]
    public function edit(Request $request, Reservation $reservation, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(ReservationType::class, $reservation);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('app_reservation_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->renderForm('reservation/edit.html.twig', [
            'reservation' => $reservation,
            'form' => $form,
        ]);
    }

    #[Route('/{id}', name: 'app_reservation_delete', methods: ['POST'])]
    public function delete(Request $request, Reservation $reservation, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$reservation->getId(), $request->request->get('_token'))) {
            $entityManager->remove($reservation);
            $entityManager->flush();
        }

        return $this->redirectToRoute('app_reservation_index', [], Response::HTTP_SEE_OTHER);
    }

    #[Route('/api/reservations', name: 'api_reservation_index', methods: ['GET'])]
    public function apiIndex(ReservationRepository $reservationRepository): JsonResponse
    {
        $reservations = $reservationRepository->findAll();

        // Convert your data to an array or use a serializer if needed
        $data = [];
        foreach ($reservations as $reservation) {
            $data[] = [
                'id' => $reservation->getId(),
                'type' => $reservation->getType(),
                'prix' => $reservation->getPrix(),
                // Add other fields as needed
            ];
        }

        // Return the data as JSON
        return $this->json($data);
    }

    #[Route('/api/reservations/new', name: 'api_reservation_new', methods: ['POST'])]
    public function apiNew(Request $request, EntityManagerInterface $entityManager): JsonResponse
    {
        // Assuming your ReservationType form is used for both HTML and API requests
        $reservation = new Reservation();
        $form = $this->createForm(ReservationType::class, $reservation);
        $data = json_decode($request->getContent(), true);

        // Handle JSON data for API requests
        $form->submit($data);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($reservation);
            $entityManager->flush();

            // Return the newly created resource as JSON
            return $this->json([
                'id' => $reservation->getId(),
                'type' => $reservation->getType(),
                'prix' => $reservation->getPrix(),
                // Add other fields as needed
            ], JsonResponse::HTTP_CREATED);
        }

        // Return validation errors as JSON
        return $this->json(['errors' => $this->getFormErrors($form)], JsonResponse::HTTP_BAD_REQUEST);
    }
     /**
     * Helper method to retrieve form errors
     *
     * @param \Symfony\Component\Form\FormInterface $form
     * @return array
     */
    private function getFormErrors(\Symfony\Component\Form\FormInterface $form): array
    {
        $errors = [];
        foreach ($form->getErrors(true) as $error) {
            $errors[] = $error->getMessage();
        }

        foreach ($form->all() as $childForm) {
            if ($childErrors = $this->getFormErrors($childForm)) {
                $errors[$childForm->getName()] = $childErrors;
            }
        }

        return $errors;
    }

    #[Route('/api/reservations/{id}', name: 'api_reservation_show', methods: ['GET'])]
    public function apiShow(Reservation $reservation): JsonResponse
    {
        // Convert your entity to an array or use a serializer if needed
        $data = [
            'id' => $reservation->getId(),
            'type' => $reservation->getType(),
            'prix' => $reservation->getPrix(),
            // Add other fields as needed
        ];

        // Return the data as JSON
        return $this->json($data);
    }

    #[Route('/api/reservations/{id}/edit', name: 'api_reservation_edit', methods: ['PUT'])]
    public function apiEdit(Request $request, Reservation $reservation, EntityManagerInterface $entityManager): JsonResponse
    {
        $form = $this->createForm(ReservationType::class, $reservation);
        $data = json_decode($request->getContent(), true);

        // Handle JSON data for API requests
        $form->submit($data, false); // Set the second parameter to false to avoid clearMissing

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            // Return the updated resource as JSON
            return $this->json([
                'id' => $reservation->getId(),
                'type' => $reservation->getType(),
                'prix' => $reservation->getPrix(),
                // Add other fields as needed
            ]);
        }

        // Return validation errors as JSON
        return $this->json(['errors' => $this->getFormErrors($form)], JsonResponse::HTTP_BAD_REQUEST);
    }

    
    #[Route('/api/reservations/{id}', name: 'api_reservation_delete', methods: ['DELETE'])]
    public function apiDelete(Request $request, Reservation $reservation, EntityManagerInterface $entityManager): JsonResponse
    {
        // No need to check CSRF token for API, since it's not a traditional form submission

        $entityManager->remove($reservation);
        $entityManager->flush();

        // Return a success message as JSON
        return $this->json(['message' => 'Reservation deleted successfully.']);
    }
}
