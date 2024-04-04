import DataTable from 'datatables.net';
import $ from "jquery";

export default class Personas {
    constructor(config) {
        this.api = config.api;
        this.idTablaPersonas = config.idTablaPersonas;
    }

    render(personas) {
        this.tablaPersonas = new DataTable(`#${this.idTablaPersonas}`, {
            data: personas,
            autoWidth: true,
            responsive: true,
            language: {
                url: `${this.api.getContext()}/DataTables/i18n/es-CL.json`,
            },
            columns: [
                { data: "id" },
                { data: "nombre" },
                { data: "apellido" },
                {
                    data: "pais",
                    render: data => data ? data.nombre : ''
                },
                {
                    data: null,
                    render: (data, type, row) => {
                        return `
                            <button class="btn btn-sm btn-primary edit-btn">Editar</button>
                            <button class="btn btn-sm btn-danger delete-btn">Eliminar</button>
                        `;
                    }
                }
            ],
            dom: '<"datatable-header"fl><"datatable-scroll-wrap"t><"datatable-footer"ip>'
        });
    }

    cargarPaises() {
        this.api.obtenerPaises()
            .then(paises => {
                const selectPais = $('#pais');
                selectPais.empty();
                selectPais.append($('<option>', {
                    value: '',
                    text: 'Seleccione un país',
                    disabled: true,
                    selected: true
                }));
                paises.forEach(pais => {
                    selectPais.append($('<option>', {
                        value: pais.id,
                        text: pais.nombre
                    }));
                });
            })
            .catch(error => {
                console.error('Error al cargar los países:', error);
            });
    }
}
