package com.example.media;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MediaService {
    MediaRepository mediaRepository;
    public Media save(Media media) {
        return mediaRepository.save(media);
    }

    public void deleteById(long id) {
        mediaRepository.deleteById(id);
    }

    public List<Media> retrieveAllMedias() {
        return mediaRepository.findAll();
    }
    public byte[] generateQRCode(Media user) {
        String content = "Nom: " + user.getNomMedia() + "\nType: " + user.getTypeMedia() + "\nEmail: " + user.getEmail() ;

        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 300, 300);

            BufferedImage bufferedImage = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();

            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, 300, 300);
            graphics.setColor(Color.BLACK);

            for (int i = 0; i < 300; i++) {
                for (int j = 0; j < 300; j++) {
                    if (bitMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            javax.imageio.ImageIO.write(bufferedImage, "png", baos);
            return baos.toByteArray();

        } catch (WriterException | java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
