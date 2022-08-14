import { reactive } from 'vue'
import { useI18n } from '@/hooks/web/useI18n'
import { CrudSchema, useCrudSchemas } from '@/hooks/web/useCrudSchemas'
import { DICT_TYPE } from '@/utils/dict'
const { t } = useI18n() // 国际化
// 表单校验
export const rules = reactive({
})
// CrudSchema
const crudSchemas = reactive<CrudSchema[]>([
    {
      label: '主键',
      field: 'id',
      type: 'index',
      form: {
         show: false
      },
      detail: {
         show: false
      }
    },
    {
      label: '用户id',
      field: 'userId',
      form: {
          show: true,
      },
      search: {
         show: true
      }
    },
    {
      label: '项目名称',
      field: 'name',
      form: {
          show: true,
      },
      search: {
         show: true
      }
    },
    {
      label: '项目类型',
      field: 'type',
      form: {
          show: true,
      },
      search: {
         show: true,
         component: 'Select',
         componentProps: {
             option: [{'','请选择字典生成'}]
         }
      }
    },
    {
      label: '行业',
      field: 'industry',
      form: {
          show: true,
      },
      search: {
         show: true
      }
    },
    {
      label: '配置参数',
      field: 'config',
      form: {
          show: true,
      },
      search: {
         show: true
      }
    },
    {
      label: 'logo',
      field: 'logo',
      form: {
          show: true,
      },
      search: {
         show: true
      }
    },
    {
      label: '封面',
      field: 'cover',
      form: {
          show: true,
      },
      search: {
         show: true
      }
    },
    {
      label: '页面配置',
      field: 'pages',
      form: {
          show: true,
      },
      search: {
         show: true
      }
    },
    {
      label: '创建时间',
      field: 'createTime',
      form: {
         false
      },
      search: {
         show: true,
         component: 'DatePicker',
         componentProps: {
             type: 'datetimerange',
             valueFormat: 'YYYY-MM-DD HH:mm:ss'
         }
      }
    },
    {
        label: t('table.action'),
        field: 'action',
        width: '240px',
        form: {
            show: false
        },
        detail: {
            show: false
        }
    }
])

export const { allSchemas } = useCrudSchemas(crudSchemas)