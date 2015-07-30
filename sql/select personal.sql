CREATE OR REPLACE FUNCTION subcentro_licto.f_select_personal(OUTapellidos character varying,OUTnombres character varying,OUTfecha_nacimiento date,OUTcedula_ciudadania character varying,OUTsexo integer,OUTformacion integer,OUTespecialidad_subespecialidad integer,OUTnacionalidad integer,OUTautoidentificacion integer,OUTcodigo_mps character varying)  
RETURNS SETOF record AS
$BODY$
begin
return QUERY SELECT  id_personal,apellidos,nombres,fecha_nacimiento,cedula_ciudadania,sexo,formacion,especialidad_subespecialidad,pnacionalidad,autoidentificacion,codigo_mps
from subcentro_licto.personal;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
