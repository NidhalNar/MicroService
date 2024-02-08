import { SponsorModel } from './../models/SponsorModel';
import { EvenementModel } from './../models/EvenementModel';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SponsorsService {

  constructor(private http : HttpClient) { }
  httpOptions =
  {
    headers: new HttpHeaders({
      'Content-Type': 'application/Json',
      
    })
  }

  getSponsorList():Observable<SponsorModel[]>
  {
    return this.http.get<SponsorModel[]>("http://localhost:8097/sponsors");
  }


  
AddSponsor(data : any)
{
  return this.http.post<any>("http://localhost:8097/sponsors",data);

}
DeleteSponsor(idSponsor: any): Observable<any> {
    return this.http.delete<any>(`http://localhost:8097/sponsors/${idSponsor}`);
  }
  
UpdateSponsorById(idSponsor: any, updatedData: any): Observable<any> {
    return this.http.put<any>(`http://localhost:8097/sponsors/${idSponsor}`, updatedData);
  }

 
  

}