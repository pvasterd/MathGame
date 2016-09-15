//package nl.vgames.max.api
//
//
//import akka.actor.ActorSystem
//import akka.stream.ActorMaterializer
//import akka.http.scaladsl.Http
//import akka.http.scaladsl.server.Route
//import akka.http.scaladsl.server.Directives._
//
//import spray.json.DefaultJsonProtocol._
//
//import nl.vgames.max.game._
//
//import scala.io.StdIn
//
///**
//  * Created by maxvasterd on 08/09/16.
//  */
//
//
//object WebServer {
//
//
//  implicit val plusFormat = jsonFormat2(Plus)
//  implicit val minusFormat = jsonFormat2(Minus)
//  implicit val numberFormat = jsonFormat1(Number)
//
//
//  def start() {
//
//    implicit val system = ActorSystem()
//    implicit val materializer = ActorMaterializer()
//
//    val route: Route =
//      path("getPlus") {
//        get {
//          complete {
//            Number(1)
//          }
//        }
//      }
//
//
//    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)
//
//    println("Server is running online at http://localhost:8080/\n press ENTER to stop ... ")
//    StdIn.readLine()
//    bindingFuture
//      .flatMap(_.unbind())
//      .onComplete(_ => system.terminate())
//
//  }
//}
