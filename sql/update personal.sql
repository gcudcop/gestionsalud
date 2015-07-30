CREATE OR REPLACE FUNCTION subcentro_licto.f_update_personal(papellidos character varying,pnombres character varying,pfecha_nacimiento date,pcedula_ciudadania character varying,psexo integer,pformacion integer,pespecialidad_subespecialidad integer,pnacionalidad integer,pautoidentificacion integer,pcodigo_mps character varying)
RETURNS boolean AS
$BODY$declare band boolean;
begin
UPDATE subcentro.personal SET apellidos=$1,nombres=$2,fecha_nacimiento=$3,cedula_ciudadania=$4,sexo=$5,formacion=$6,especialidad_subespecialidad=$7,pnacionalidad=$8,autoidentificacion=$9,codigo_mps=$10
WHERE id_personal=$10;
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;