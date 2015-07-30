CREATE OR REPLACE FUNCTION subcentro_licto.f_update_paciente(papellidos character varying, pnombres character varying, phistoria_clinica character varying, psexo integer, pfecha_nacimiento date, pcedula_ciudadana character varying, pnacionalidad integer, pautoidentificacion integer, paporta_afiliado integer, pprovincia character varying, pcanton character varying, pparroquia character varying, pbarrio character varying, psector character varying, precinto character varying, pcomunidad character varying, pdireccion character varying, ptelefono character varying, pgrupo_prioritario integer)
  RETURNS boolean AS
$BODY$declare band boolean;
begin
UPDATE subcentr.victima SET apellidos=$1,nombres=$2,historia_clinica=$3,sexo=$4,fecha_nacimiento=$5,cedula_ciudadana=$6,nacionalidad=$7,autoidentificacion=$8,aporta_afiliado=$9,provincia=$10,canton=$11,parroquia=$12,barrio=$13,sector=$14,recinto=$15,comunidad=$16,direccion=$17,telefono=$18,grupo_prioritario=$19
WHERE id_paciente=$19;
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
