CREATE OR REPLACE FUNCTION subcentro_licto.f_insert_personal(papellidos character varying, pnombres character varying, pfecha_nacimiento date, pcedula_ciudadania character varying, psexo integer, pformacion integer, pespecialidad_subespecialidad integer, pnacionalidad integer, pautoidentificacion integer, pcodigo_mps character varying)
  RETURNS boolean AS
$BODY$declare band boolean;
begin
INSERT INTO subcentro_licto.f_insert_personal(apellidos,nombres,fecha_nacimiento,cedula_ciudadania,sexo,formacion,especialidad_subespecialidad,pnacionalidad,autoidentificacion,codigo_mps) VALUES ($1,$2,$3,$4,$5,$6,$7,$8,$9,$10);
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;