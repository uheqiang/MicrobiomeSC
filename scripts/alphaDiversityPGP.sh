java -cp lib/*:bin/:../FlexSC/lib/*:../FlexSC/bin:lib/* util.GenRunnable alphaDiversity.AlphaDiversity data/pgp_species_case_part1_nozeros_transpose.txt data/pgp_species_control_part1_nozeros_transpose.txt  $1&

java -cp lib/*:bin/:../FlexSC/lib/*:../FlexSC/bin:lib/* util.EvaRunnable alphaDiversity.AlphaDiversity data/pgp_species_case_part2_nozeros_transpose.txt data/pgp_species_control_part2_nozeros_transpose.txt $1
