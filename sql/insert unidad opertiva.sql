CREATE OR REPLACE FUNCTION subcentro_licto.f_insert_Unidad_Operativa(pnombre_uo character varying,pprovincia character varying,pcanton character varying,pparroquia character varying,pzona character varying,pdistrito character varying,pcircuito character varying,ptipo_uo character varying,pinstitucion_sistema integer)  
RETURNS boolean AS
$BODY$declare band boolean;
begin
INSERT INTO subcentro_licto.f_insert_medicamento(nombre_uo,provincia,canton,parroquia,zona,distrito,circuito,tipo_uo,institucion_sistema) VALUES ($1,$2,$3,$4,$5,$6,$7,$8,$9,$10);
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;