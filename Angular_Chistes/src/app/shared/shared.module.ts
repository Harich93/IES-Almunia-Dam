import { NgModule } from "@angular/core";
import { CleanTextPipe } from './clean-text.pipe';


@NgModule({
    declarations: [ CleanTextPipe ],
    exports: [ CleanTextPipe ],
    imports: [],
})
export class SharedModule {

}