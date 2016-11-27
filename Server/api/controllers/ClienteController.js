/**
 * ClienteController
 *
 * @description :: Server-side logic for managing Clientes
 * @help        :: See http://sailsjs.org/#!/documentation/concepts/Controllers
 */

module.exports = {
	salvar: function(req, res) {
        Cliente.create({
            nome: req.param('nome'),
            email: req.param('email'),
            senha: req.param('senha')
        }).then(function(cliente) {
            return res.json(cliente);
        }).catch(function cbError(err) {
            return res.json(500, {
                result: 'BAD_REQUEST',
                reason: err
            });
        });
    },

    acessar: function(req, res) {
        Cliente.find({
            email: req.param('email'),
            senha: req.param('senha')
        }).then(function(cliente) {
            
            if (!cliente) {
                return res.json(500, {
                    result: 'BAD_REQUEST',
                    reason: err
                });
            }
            
            return res.json(cliente);
        }).catch(function cbError(err) {
            return res.json(500, {
                result: 'BAD_REQUEST',
                reason: err
            });
        });
    }
};

