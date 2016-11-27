/**
 * ClienteController
 *
 * @description :: Server-side logic for managing Clientes
 * @help        :: See http://sailsjs.org/#!/documentation/concepts/Controllers
 */

module.exports = {
	attributes: {
        nome: {
			type: 'string',
			required: true,
			size: 100
		},

        email: {
			type: 'string',
			required: true,
			size: 100
		},
        
        senha: {
			type: 'string',
			required: true,
			size: 100
		}, 

        contratos: {
            model: 'Contrato'
        }
    }
};

