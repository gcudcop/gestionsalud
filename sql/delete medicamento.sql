CREATE OR REPLACE FUNCTION subcentro_licto.f_delete_medicamento(pid_medicamento bigint)
  RETURNS boolean AS
$BODY$declare band boolean;
begin
DELETE FROM subcentro_licto.medicamento WHERE id_medicamento=$1;
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;