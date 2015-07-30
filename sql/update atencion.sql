CREATE OR REPLACE FUNCTION subcentro_licto.f_update_atencion(pdiagnostico character varying,psindrome character varying,morbilidad character varying,pprevencion character varying,pdescripcion character varying,penfermedad character varying,pfecha_atencion date,plugar_atencion character varying)  RETURNS boolean AS
$BODY$declare band boolean;
begin
UPDATE subcentro.atencion SET diagnostico=$1,sindrome=$2,morbilidad=$3,prevencion=$4,descripcion=$5,enfermedad=$6,fecha_atencion=$7,lugar_atencion=$8
WHERE id_atencion=$8;
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;