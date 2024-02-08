import { LieuModel } from './../models/LieuModel';
import { EvenementModel } from './../models/EvenementModel';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LieuService {

  constructor(private http : HttpClient) { }
  httpOptions =
  {
    headers: new HttpHeaders({
      'Content-Type': 'application/Json',
      
    })
  }

  getLieuList():Observable<LieuModel[]>
  {
    return this.http.get<LieuModel[]>("http://localhost:8097/lieus");
  }


  
AddLieu(data : any)
{
  return this.http.post<any>("http://localhost:8097/lieus",data);

}
DeleteLieu(idLieu: any): Observable<any> {
    return this.http.delete<any>(`http://localhost:8097/lieus/${idLieu}`);
  }
  
UpdateLieuById(idLieu: any, updatedData: any): Observable<any> {
    return this.http.put<any>(`http://localhost:8097/lieus/${idLieu}`, updatedData);
  }

 
  

}