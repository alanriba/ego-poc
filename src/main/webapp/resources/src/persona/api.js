import BaseApi from "../commons/BaseApi";

export default class PersonaApi extends BaseApi {
    constructor(config) {
        super(config);
        this.baseEndpoint = `${config.context}/api/personas`;
    }

    obtenerPersonas() {
        const url = `${this.baseEndpoint}`;
        return PersonaApi.get(url);
    }

    obtenerPersonaPorId(id) {
        const url = `${this.baseEndpoint}/${id}`;
        return PersonaApi.get(url);
    }

    crearPersona(persona) {
        const input = {
            url: this.baseEndpoint,
            data: persona
        };
        return PersonaApi.post(input);
    }

    actualizarPersona(id, persona) {
        const input = {
            url: `${this.baseEndpoint}/${id}`,
            data: persona
        };
        return PersonaApi.put(input);
    }

    eliminarPersona(id) {
        const url = `${this.baseEndpoint}/${id}`;
        return PersonaApi.delete(url);
    }
}
