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
        is("h0F".U){

        }
        is("h13".U){
            switch(io.Instin(14,12)){
                is(0.U){
                    //addi
                     Regout:=io.Regsi(.io.Instin(19,15)) + .io.Instin(31,20)
                }
                is(1.U){
                    //slli
                }
                is(2.U){
                    //slti
                     Regout:=io.Regsi(.io.Instin(19,15)) < .io.Instin(31,20) ? 1:0
                }
                is(3.U){
                    //sltiu unsigned

                }
                is(4.U){
                    //xori
                    Regout:=io.Regsi(.io.Instin(19,15)) ^ .io.Instin(31,20)
                }
                is(5.U){
                    switch(io.Instin(31,25)){
                        is("b0000000".U){
                            //srli

                        }
                         is("b0100000".U){
                            //srai
                        }
                    }

                }
                is(6.U){
                    //ori
                    Regout:=io.Regsi(.io.Instin(19,15)) | .io.Instin(31,20)
            }
                is(7.U){
                    //andi
                    Regout:=io.Regsi(.io.Instin(19,15)) & .io.Instin(31,20)
                }
            }
        }

    }

}
