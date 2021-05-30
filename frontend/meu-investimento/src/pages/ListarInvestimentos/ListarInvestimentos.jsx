import "antd/dist/antd.css"
import { Table, Button, message, Layout, Menu } from 'antd'
import { Link } from 'react-router-dom'
import Column from "antd/lib/table/Column"
import {useEffect, useState} from 'react'
import investimentoService from "../../service/investimentoService"

const { Header, Content, Footer } = Layout
const { column } = Table

export default function ListarInvestimentos() {
    const [investimentos, setInvestimentos] = useState([])

    useEffect(() => {
        refreshInvestimentos()
        return () => {

        }
    }, [])

    async function refreshInvestimentos(){
        investimentoService.retrieveAllInvestimentos().then(
            response => {
                setInvestimentos(response.data)
            }
        )
    }

    function remove(record){
        investimentoService.deleteInvestimento(record.id)
        message.success('Investimento removido com sucesso.')
    }

    return (
        <div className="container">
            <Layout className="layout">
                <Header>
                    <div className="logo" />
                    <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['2']}>
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
                        <h2>INVESTIMENTOS</h2>
                        <Table dataSource={investimentos}>
                            <Column title="Código do ativo" dataIndex="codigoAtivo" key="codigoAtivo" />
                            <Column title="Valor" dataIndex="valorCota" key="valorCota" />
                            <Column title="Quantidade de cotas" dataIndex="quantidadeCotas" key="quantidadeCotas" />
                            <Column title="Data da compra" dataIndex="dataCompra" key="dataCompra" />
                            <Column title="Remover" key="atualizar" 
                                render={(text, record) => (<Button onClick={() => remove(record)}
                                type="primary">Remover</Button>)}
                            />
                        </Table>
                    </div>
                </Content>
                <Footer style={{textAlign: 'center'}}>Desenvolvido por Wilembergson</Footer>
            </Layout>
        </div>
    )
}