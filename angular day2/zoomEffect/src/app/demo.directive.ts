import { Directive,ViewContainerRef,TemplateRef, Input} from '@angular/core';

@Directive({
  selector: '[appDemo]'
})
export class DemoDirective {

  constructor(private templateRef: TemplateRef<any>, private viewContainer: ViewContainerRef) { }

  @Input() set appDemo(count: number) {
    for (let i = 0; i < count; i++) {
      this.viewContainer.createEmbeddedView(this.templateRef);
      console.log("View: ",this.viewContainer);
      console.log("TemplateRef: ",this.templateRef);
      
    }
  }

}
