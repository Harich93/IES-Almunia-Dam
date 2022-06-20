import { Directive, ElementRef, HostListener, Input, OnInit, Renderer2 } from "@angular/core";
import { iChImage } from './ch-img.interface';


@Directive({
    selector: '[ch-img]'
})
export class ChImgDirective implements OnInit {
    
    @Input('ch-img') props: iChImage = { className: '' }
    
    @HostListener('mouseover') onMouseHover() {
        this.changeClass();
        this.setSecondImage();
    }

    @HostListener('mouseout') onMouseOut() {
        this.default();
    }

    private urlTemplateImg: string;
    private urlSecondImg: string = 'https://images.pexels.com/photos/1707820/pexels-photo-1707820.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260';

    constructor( private el: ElementRef<HTMLImageElement>, private render: Renderer2 ) {
        this.urlTemplateImg = this.el.nativeElement.src;
    }
    
    ngOnInit(): void {}

    changeClass(): void {
        this.render.addClass( this.el.nativeElement, this.props.className );
    } 

    setSecondImage(): void {
        this.render.setAttribute( this.el.nativeElement, 'src', this.props.urlImg || this.urlSecondImg );
    }

    default(): void {
        this.render.removeClass( this.el.nativeElement, this.props.className );
        this.render.setAttribute(this.el.nativeElement, 'src', this.urlTemplateImg );
    }



}