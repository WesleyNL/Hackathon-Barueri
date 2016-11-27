/**
 * Veiculo.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
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

