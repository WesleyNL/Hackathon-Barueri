/**
 * VeiculoController
 *
 * @description :: Server-side logic for managing Veiculoes
 * @help        :: See http://sailsjs.org/#!/documentation/concepts/Controllers
 */

module.exports = {
	attributes: {
        modelo: {
			type: 'string',
			required: true,
			size: 100
		},

        ano: {
			type: 'integer',
			required: true
		},

        tempoHabilitado: {
            type: 'date',
            required: true
        },

        fotoFrontal: {
            type: 'string',
            required: true,
            size: 10000
        },

        fotoLateral: {
            type: 'string',
            required: true,
            size: 10000
        },

        hasOutrosMotoristas: {
            type: 'boolean',
            required: true
        },

        hasAlarme: {
            type: 'boolean',
            required: true
        }
    }
};

