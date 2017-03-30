insert into T_BIZ_CODE_CATALOG (ID, NAME, DETAIL)
values ('402881ef390a0baa01390a27ccde0005', '系统', null);
commit;
insert into T_BIZ_CODE (ID, CID, NAME, TYPE, KEYWORD, DETAIL, USED)
values ('11', '402881ef390a0baa01390a27ccde0005', '字典类型', '1', 'sys-parameter-busicodetype', null, '1');
commit;
insert into T_BIZ_CODE_ITEM (ID, BUSICODEID, PID, NAME, VALUE, POS, DETAIL, USED)
values ('1', '11', null, '列表', '1', '1', null, '1');

insert into T_BIZ_CODE_ITEM (ID, BUSICODEID, PID, NAME, VALUE, POS, DETAIL, USED)
values ('2', '11', null, '树形', '2', '2', null, '1');
commit;