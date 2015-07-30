CREATE OR REPLACE FUNCTION subcentro_licto.f_delete_unidad_operativa(pid_uo bigint)
  RETURNS boolean AS
$BODY$declare band boolean;
begin
DELETE FROM subcentro_licto.unidad_operativa WHERE id_uo=$1;
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;