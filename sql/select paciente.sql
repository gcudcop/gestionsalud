CREATE OR REPLACE FUNCTION subcentro_licto.f_select_paciente(OUT apellidos character varying, OUT nombres character varying, OUT historia_clinica character varying, OUT sexo integer, OUT fecha_nacimiento date, OUT cedula_ciudadana character varying, OUT nacionalidad integer, OUT autoidentificacion integer, OUT aporta_afiliado integer, OUT provincia character varying, OUT canton character varying, OUT parroquia character varying, OUT barrio character varying, OUT sector character varying, OUT recinto character varying, OUT comunidad character varying, OUT direccion character varying, OUT telefono character varying, OUT grupo_prioritario integer)
  RETURNS SETOF record AS
$BODY$
begin
return QUERY SELECT  id_paciente,apellidos,nombres,historia_clinica,sexo,fecha_nacimiento,cedula_ciudadana,nacionalidad,autoidentificacion,aporta_afiliado,provincia,canton,parroquia,barrio,sector,recinto,comunidad,direccion,telefono,grupo_prioritario
from subcentro_licto.paciente;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;