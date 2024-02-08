import { EvenementModel } from './../models/EvenementModel';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EvemenetService {

  constructor(private http : HttpClient) { }
  httpOptions =
  {
    headers: new HttpHeaders({
      'Content-Type': 'application/Json',
      
    })
  }

  getEvenementList():Observable<EvenementModel[]>
  {
    return this.http.get<EvenementModel[]>("http://localhost:8097/evenements");
  }


  
AddEvenement(data : any)
{
  return this.http.post<any>("http://localhost:8097/evenements",data);

}
DeleteEvenement(id: any): Observable<any> {
    return this.http.delete<any>(`http://localhost:8097/evenements/${id}`);
  }
  
UpdateEvenementById(id: any, updatedData: any): Observable<any> {
    return this.http.put<any>(`http://localhost:8097/evenements/${id}`, updatedData);
  }

 
  

}