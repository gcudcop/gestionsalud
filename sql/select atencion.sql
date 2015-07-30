CREATE OR REPLACE FUNCTION subcentro_licto.f_select_atencion(OUT diagnostico character varying,OUT sindrome character varying,OUT morbilidad character varying,OUT prevencion character varying,OUT descripcion character varying,OUT enfermedad character varying,OUT fecha_atencion date,OUT lugar_atencion character varying)
  RETURNS SETOF record AS
$BODY$
begin
return QUERY SELECT  id_atencion,diagnostico,sindrome,morbilidad,prevencion,descripcion,enfermedad,fecha_atencion,lugar_atencion
from subcentro_licto.atencion;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;