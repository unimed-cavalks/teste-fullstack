import { Injectable, Inject } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpErrorResponse,
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

    constructor() { }

    

    intercept(req: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
        
        const tokenString = localStorage.getItem("access_token");
        const url = req.url;


        if( tokenString && !url.endsWith('/oauth/token') ) {
            const token = JSON.parse(tokenString);
            const jwt = token.access_token;
            req = req.clone({
                setHeaders : {
                    Authorization: 'Bearer ' + jwt
                }
            }) 
        }
        return  next.handle(req);
    }
  
  
  
}
