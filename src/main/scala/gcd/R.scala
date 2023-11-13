import chisel3._
import chisel3.util._

class R extends Module {
    val io = IO(new Bundle {
        val Instin  =Input(Bits(32.W))
        val Regsi   =Input(Vec(4,SInt(32.W)))
        val Regso   =Output(SInt(32.W))
    })
    // we want to know which kind of operation it is.
    val Regout =RegInit(0.S(32.W))
    val opcode = WireDefault("b0110011".U(7.W)) //Opcode for R instructions
    when(io.Instin(6,0) === opcode){  //testing if it is the right OPCODE
        switch(io.Instin(14,12)){
            is("b000".U){
                switch (io.Instin(31,25)){
                    is("b0000000".U){
                        
                        Regout:=io.Regsi(io.Instin(19,15))+io.Regsi(io.Instin(24,20))
                        //add
                    }
                    is("b0100000".U){
                        Regout:=io.Regsi(io.Instin(19,15))-io.Regsi(io.Instin(24,20))
                        //sub
                    }
                }
            }
            is("b001".U){
                //sll
            }
            is("b010".U){
                //slt
            }
            is("b011".U){
                //sltu
            }
            is("b100".U){
                //xor
            }
            is("b101".U){
                switch (io.Instin(31,25)){
                    is("b0000000".U){
                        //srl
                    }
                    is("b0100000".U){
                        //sra
                    }
                }
            }
            is("b110".U){
                //or
            }
            is("b111".U){
                //and
            }
        }
    }
io.Regso := Regout
}