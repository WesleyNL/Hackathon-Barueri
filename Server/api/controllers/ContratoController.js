/**
 * ContratoController
 *
 * @description :: Server-side logic for managing Contratoes
 * @help        :: See http://sailsjs.org/#!/documentation/concepts/Controllers
 */

module.exports = {
	attributes: {

        cliente: {
            model: 'Cliente',
            required: true
        },

        veiculo: {
            model: 'Veiculo',
            required: true
        }
    }
};

