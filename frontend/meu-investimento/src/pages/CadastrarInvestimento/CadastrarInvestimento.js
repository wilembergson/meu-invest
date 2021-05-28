import { Form, Button, message, DatePicker, Layout, Menu, Input, InputNumber} from 'antd'
import { Link } from 'react-router-dom'

const {Header, Content, Footer} = Layout

export default function CadastrarInvestimento(){
   
    const layout = {
        labelCol: {
          span: 4,
        },
        wrapperCol: {
          span: 3,
        },
      };
      const tailLayout = {
        wrapperCol: {
          offset: 4,
          
        },
      };
   
      const onFinish = (value) => {
          message.success("Investimento salvo com sucesso.")
      }

      const onFinishFailed = (erroInfo) => {
        message.danger("Investimento não foi salvo.")
        console.log('Failed', erroInfo)
    }

    return (
        <div className="container">
            <Layout className="layout">
                <Header>
                    <div className="logo" />
                    <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['1']}>
                        <Menu.Item key="1">
                            <Link to="/cadastrar-investimento">Cadastrar investimento</Link>
                        </Menu.Item>
                        <Menu.Item key="2">
                            <Link to="/listar-investimentos">Listar investimentos</Link>
                        </Menu.Item>
                    </Menu>
                </Header>
                <Content style={{ padding: '0 50px ' }}>
                    <div className="site-layout-content">
                        <h2>CADASTRAR INVESTIMENTO</h2>
                        <Form {...layout} name="basic" 
                        initialValues={{
                            remember: true,
                        }}
                        oninFish={onFinish}
                        >
                            <Form.Item
                            label="Código do ativo"
                            name="codigoAtivo"
                            rules={[
                                {
                                    required: true,
                                    message: 'Insira o código do ativo.'
                                }
                            ]}
                            >
                                <Input/>
                            </Form.Item>

                            <Form.Item
                            label="Valor"
                            name="valor"
                            rules={[
                                {
                                    required: true,
                                    message: 'Insira o valor da cota.'
                                }
                            ]}
                            >
                                <Input/>
                            </Form.Item>

                            <Form.Item
                            label="Quantidade de cotas"
                            name="quantidadeCotas"
                            rules={[
                                {
                                    required: true,
                                    message: 'Insira a quantidade de cotas.'
                                }
                            ]}
                            >
                                <InputNumber/>
                            </Form.Item>

                            <Form.Item
                            label="Data da compra"
                            name="dataCompra"
                            rules={[
                                {
                                    required: true,
                                    message: 'Insira a data da compra.'
                                }
                            ]}
                            >
                                <DatePicker/>
                            </Form.Item>

                            <Form.Item {...tailLayout}>
                                <Button type="primary" htmlType="submit">Salvar</Button>
                            </Form.Item>
                        </Form>
                    </div>
                </Content>
                <Footer style={{textAlign: 'center'}}>Desenvolvido por Wilembergson</Footer>
            </Layout>
        </div>
    )
}