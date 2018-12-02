import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import {enableProdMode} from '@angular/core';

// Enable production mode unless running locally
if (!/localhost/.test('localhost:8080')) {
    enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule);


