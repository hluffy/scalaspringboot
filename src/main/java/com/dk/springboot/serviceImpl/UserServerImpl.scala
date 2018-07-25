package com.dk.springboot.serviceImpl

import com.dk.springboot.entity.User
import com.dk.springboot.service.UserServer
import com.dk.springboot.until.DBConnectionPool
import org.springframework.stereotype.Service

@Service
class UserServerImpl extends UserServer{

    override def getUsers: List[User] = {
        val conn = DBConnectionPool.getConn
        val sql = "select * from users"
        val st = conn.createStatement()
        val rs = st.executeQuery(sql)

        var infos:List[User] = List()
        while(rs.next()){
            val info = new User
            info.id = rs.getLong("id")
            info.name = rs.getString("name")
            info.birthday = rs.getDate("birthday")
            info.telephone = rs.getString("telephone")

            infos = infos :+ info
        }

        return infos
    }

}
