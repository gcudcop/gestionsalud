CREATE OR REPLACE FUNCTION subcentro_licto.f_delete_personal(pid_personal bigint)
  RETURNS boolean AS
$BODY$declare band boolean;
begin
DELETE FROM subcentro_licto.personal WHERE id_personal=$1;
band=true;
return band;
end;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;