CREATE OR REPLACE FUNCTION subcentro_licto.f_insert_atencion(pdiagnostico character varying,psindrome character varying,pmorbilidad character varying,pprevencion character varying,pdescripcion character varying,penfermedad character varying,pfecha_atencion date,plugar_atencion character varying) 
 RETURNS boolean AS
$BODY$declare band boolean;
begin
INSERT INTO subcentro_licto.f_insert_atencion(diagnostico,sindrome,morbilidad,prevencion,descripcion,enfermedad,fecha_atencion,lugar_atencion) 
VALUES ($1,$2,$3,$4,$5,$6,$7,$8);
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;