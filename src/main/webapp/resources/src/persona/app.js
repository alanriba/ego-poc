// Import our custom CSS
import '../scss/styles.scss';
import bootstrap from 'bootstrap';

import Api from "./api";
import apiPais from "../paises/Api";
import Personas from "./persona"
import { showError } from "../commons/Utils";

export default class App {
    constructor(config) {
        this.apiPais = new apiPais(config);
        this.api = new Api(config);
        this.personas = new Personas({ idTablaPersonas: 'personas', api: this.api, ...config });
        this.renderPersonas();
    }

    renderPersonas() {
        this.api.obtenerPersonas()
            .then(personas => {
                this.personas.render(personas);
            })
            .catch(error => {
                showError(error);
            });
    }
}

globalThis.app = new App(config);
