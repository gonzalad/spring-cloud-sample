import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { HelloService } from './hello.service';

@Component({
    selector: 'hello',
    template: ` 
        <div>{{hello}}</div>
    `,
    providers: [HelloService]
})
export class HelloComponent implements OnInit {
    hello = 'Hello';

    constructor(private helloService: HelloService) {
    }

    ngOnInit() {
        this.getHello();
    }

    getHello() {
        this.helloService.getHello().then(hello => this.hello = hello);
    }
}
