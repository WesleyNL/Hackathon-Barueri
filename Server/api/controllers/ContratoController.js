/**
 * ContratoController
 *
 * @description :: Server-side logic for managing Contratoes
 * @help        :: See http://sailsjs.org/#!/documentation/concepts/Controllers
 */

module.exports = {
    salvar: function(req, res) {

        Veiculo.create({
            modelo: req.param('modelo'),
            ano: req.param('ano'),
            tempoHabilitado: req.param('tempoHabilitado'),
            fotoFrontal: req.param('fotoFrontal'),
            fotoLateral: req.param('fotoLateral'),
            hasOutrosMotoristas: req.param('hasOutrosMotoristas'),
            hasAlarme: req.param('hasAlarme')
        }).then(function(veiculo) {
            
            Contrato.create({
                cliente: req.param('cliente'),
                veiculo: req.param('veiculo')
            }).then(function(contrato) {
                return res.json(contrato);
            }).catch(function cbError(err) {
                return res.json(500, {
                    result: 'BAD_REQUEST',
                    reason: err
                });
            });
    
        }).catch(function cbError(err) {
            return res.json(500, {
                result: 'BAD_REQUEST',
                reason: err
            });
        });
    },

    carregarContratos: function(req, res) {

        Contrato.find({
            cliente: req.param('cliente')
        })
        .populate('veiculo')
        .then(function(contratos) {
            return res.json(contratos);
        }).catch(function cbError(err) {
            return res.json(500, {
                result: 'BAD_REQUEST',
                reason: err
            });
        });
    }
};

