import { Component, Input, OnInit } from '@angular/core';
import { ICreateOrderRequest, IPayPalConfig } from 'ngx-paypal';
import { iArticulo } from '../../../interfaces/articulo.interface';
import { environment } from '../../../../environments/environment';
import { AuthService } from '../../../../services/auth.service';

@Component({
  selector: 'app-paypal',
  templateUrl: './paypal.component.html',
  styleUrls: ['./paypal.component.scss']
})
export class PaypalComponent implements OnInit {
  
  @Input() articulo!: iArticulo;

  public payPalConfig ? : IPayPalConfig;

  public paypal!: string;
  
  constructor( private aService: AuthService ) { 
  }
  
  ngOnInit(): void {
      this.aService.getPaypal( this.articulo.id_vendedor.trim() ).then( pay => {
        this.paypal = pay ;
        console.log( pay );
        
        this.initConfig();
      })
  }

  private initConfig(): void {
      this.payPalConfig = {
          currency: 'EUR',
          clientId: 'test',
          createOrderOnClient: (data) => <ICreateOrderRequest> {
              intent: 'CAPTURE',
              purchase_units: [{
                  description: `${ this.articulo.nombre }`,
                  amount: {
                      currency_code: 'EUR',
                      value: `${this.articulo.precio}`,
                      breakdown: {
                          item_total: {
                              currency_code: 'EUR',
                              value: `${this.articulo.precio}`
                          }
                      }
                    },
                    payee: { email_address: `${ this.paypal }` }
                }]
              },
          advanced: {
              commit: 'true'
          },
          style: {
              label: 'paypal',
              layout: 'vertical'
          },
          onApprove: async(data, actions) => {
              console.log('onApprove - transaction was approved, but not authorized', data, actions);
              const res = await actions.order.get()
              console.log( res );
          },
          onClientAuthorization: (data) => {
              console.log('onClientAuthorization - you should probably inform your server about completed transaction at this point', data);
          },
          onCancel: (data, actions) => {
              console.log('OnCancel', data, actions);

          },
          onError: err => {
              console.log('OnError', err);
          },
          onClick: (data, actions) => {
              console.log('onClick', data, actions);
          }
      };
  }
}



