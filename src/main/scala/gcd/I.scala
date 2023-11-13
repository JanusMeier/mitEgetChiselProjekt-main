import chisel3._
import chisel3.util._

class I extends Module {
    val io = IO(new Bundle {
      val Instin    = Input(Bits(32.W))
      val Regi      = Input(Vec(4,SInt(32.W)))
      val Rego      = Output(Vec(4,SInt(32.W)))
    })
    switch(io.Instin(6,0)){
        is(3.U){
            switch(io.Instin(14,12)){
                is(0.U){
                    //lb
                }
                is(1.U){
                    //lh
                }
                is(2.U){
                    //lw
                }
                is(3.U){
                    //ld
                }
                is(4.U){
                    //lbu
                }
                is(5.U){
                    //lhu
                }
                is(6.U){
                    //lwu
                }
            }

        }
        is(15.U){

        }

    }

}
