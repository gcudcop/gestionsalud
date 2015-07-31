CREATE OR REPLACE FUNCTION subcentro_licto.f_insert_paciente(papellidos character varying, pnombres character varying, phistoria_clinica character varying, psexo integer, pfecha_nacimiento date, pcedula_ciudadana character varying, pnacionalidad integer, pautoidentificacion integer, paporta_afiliado integer, pprovincia character varying, pcanton character varying, pparroquia character varying, pbarrio character varying, psector character varying, precinto character varying, pcomunidad character varying, pdireccion character varying, ptelefono character varying, pgrupo_prioritario integer)
  RETURNS boolean AS
$BODY$declare band boolean;
begin
INSERT INTO subcentro_licto.f_insert_paciente(apellidos,nombres,historia_clinica,sexo,fecha_nacimiento,cedula_ciudadana,nacionalidad,autoedificacion,aporta_afiliado,provincia,canton,parroquia,barrio,sector,recinto,comunidad,direccion,telefono,grupo_prioritario) 
VALUES ($1,$2,$3,$4,$5,$6,$7,$8,$9,$10,$11,$12,$13,$14,$15,$16,$17,$18,$19);
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;