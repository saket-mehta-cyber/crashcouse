import { Directive, ElementRef, HostListener, Input, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appMessage]'
})
export class MessageDirective {

  @Input('appMessage') message: string; 
  constructor(private el: ElementRef, private renderer: Renderer2) {
    
  }
  @HostListener('click') onClick() {
    this.el.nativeElement.innerHTML = this.message;
    this.renderer.setStyle(this.el.nativeElement, 'cursor', 'pointer');
    this.renderer.setStyle(this.el.nativeElement, 'color', 'red');
  }

}
