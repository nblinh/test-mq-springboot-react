import { Inject, Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Message, MessagePageable } from '../message/message';
import { HttpClient } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { ENV_CONFIG, EnvironmentConfig } from '../environment-config';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  public apiUrl: string;
  public path: string = "messages";
  constructor(private http: HttpClient, @Inject(ENV_CONFIG) private config: EnvironmentConfig) {
    this.apiUrl = `${config.environment.baseUrl}`;
  }

  /*  getMessages2(): Observable<Message[]> {
     return this.http.get<Message[]>(`${this.apiUrl}/${this.path}?page=1&size=1`)
       .pipe(
         tap(_ => console.log('fetched messages')),
         catchError(this.handleError<Message[]>('getMessages', []))
       );
   } */

  getMessages(page: number, size: number) {
    return this.http.get(`${this.apiUrl}/${this.path}?page=${page}&size=${size}`);

  }

  /**
 * Handle Http operation that failed.
 * Let the app continue.
 *
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
