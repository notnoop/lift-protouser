package code
package model

import net.liftweb.common._
import net.liftweb.record._

// Please note that program compiles without me providing a save method!
class User extends MegaProtoUser[User] with Record[User] {
  def meta = User
  def valUnique(errorMsg: => String)(email: String) = Nil
}

object User extends User with MetaMegaProtoUser[User] with MetaRecord[User] {
  override def screenWrap = Full(<lift:surround with="default" at="content">
			       <lift:bind /></lift:surround>)

  lazy val user = User.createRecord

  def userFromStringId(id: String) : Box[User] = Full(user)

  def findUserByUniqueId(id: String) : Box[User] = Full(user)

  def findUserByUserName(email: String) : Box[User] = Full(user)

}
