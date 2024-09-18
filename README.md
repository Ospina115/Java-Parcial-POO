# ParcialPOO

la caja de la entidad Dx dedicada a realizar examenes de diagnosticos a los afiliados de tres EPS requiere calcular el valor a pagar por un examen teniendo en cuenta:
- el afiliado a la EPS "HASTA MORIR" de nivel 1 cancela el 50% del precio del examen y los de nivel 2 el 70%
- el afiliado a la EPS "PIOR ES NA" de categoria "A" cancela el 55% del precio del examen y los de categoria "B" el 60%
- el afiliado a la EPS "DE GUATEMALA PA' GUATEPIOR" con salario hasta 2 smlv (smlv=1300000) cancela el 40% del precio del examen y los demas afiliados el 65%.

los afiliados a las EPS pueden ser de tipo COTIZANTE o BENEFICIARIO. todos los afiliados del tipo COTIZANTE tienen un 5% de descuento adicional que se calcula sobre el precio inicial del examen

Afiliado = nombre, tipoAfiliado, neeto, smls, valorPagar(), descuento(), presentarPagar() 
