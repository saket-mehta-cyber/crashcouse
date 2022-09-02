import { Directive, ElementRef, HostListener, Renderer2, Input } from '@angular/core';

@Directive({
  selector: '[appMagnify]'
})
export class MagnifyDirective {

  @Input('appMagnify') magnify: boolean; 
  constructor(private el: ElementRef, private renderer: Renderer2) { } 

  @HostListener('mouseover') onMouseHover(){
    this.renderer.setStyle(this.el.nativeElement,'transform','scale(1.2)')
    this.renderer.setStyle(this.el.nativeElement,'transition','transform .2s')
    
  }

  @HostListener('mouseleave') onMouseLeave(){
    this.renderer.setStyle(this.el.nativeElement,'transform','none')
  }

}
