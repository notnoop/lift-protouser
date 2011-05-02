package code
package model

import net.liftweb.common._
import net.liftweb.record._

import net.liftweb.mongodb.record._

// Please note that program compiles without me providing a save method!
class User extends MegaProtoUser[User] with MongoRecord[User] {
  def meta = User
  def valUnique(errorMsg: => String)(email: String) = Nil
}

object User extends User with MetaMegaProtoUser[User] with MongoMetaRecord[User] {
  override def screenWrap = Full(<lift:surround with="default" at="content">
			       <lift:bind /></lift:surround>)

  lazy val user = User.createRecord

  def userFromStringId(id: String) : Box[User] = Full(user)

  def findUserByUniqueId(id: String) : Box[User] = Full(user)

  def findUserByUserName(email: String) : Box[User] = Full(user)
}
