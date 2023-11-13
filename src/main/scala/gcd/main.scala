import chisel3._
import chisel3.util._

class main(maxCount: Int) extends Module {
  val io = IO(new Bundle {
  //Instructions
  val Instin  = Input(Bits(32.W))
  val Instout = Output(Bits(32.W))
  //Register control
  val Regsi   = Input(Vec(4,SInt(32.W)))
  val Regso   = Output(Vec(4,SInt(32.W)))
  })
//Connect all reg
val Reg=Wire(Vec(4,SInt(32.W)))
//getting started
Reg(0):=0.S
Reg(1):=2.S
Reg(2):=1.S
Reg(3):=0.S
io.Regso:=Reg
io.Instout:=io.Instin

//Modules to load
val R = Module(new R)
  R.io.Instin :=io.Instout
  R.io.Regsi  :=io.Regso
  val opcodeR = WireDefault("b0110011".U(7.W)) //Opcode for R instructions



switch(io.Instin(6,0)) {
    is("b0110011".U){
    Reg(io.Instin(11,7)) := R.io.Regso
    }
}


//have to make code to control which module writes to the Regman.
//code to excecute




}
object main extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new main(1000))
}