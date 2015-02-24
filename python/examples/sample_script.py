
source_path = "/Users/Andrew/Work/development/sample_data/data/"
output_path = "/Users/Andrew/Work/development/sample_data/series_output/"
checkpoint_dir = "/Users/Andrew/Work/development/sample_data/checkpoint/"

analysis1 = Analysis.SeriesMeanAnalysis(data_path=source_path, format="text")
output1 = Output.SeriesFileOutput(directory=output_path, prefix="output", format="text",
        include_keys="true")

analysis1.add_output(output1)

tsc.add_analysis(analysis)

tsc.set_checkpoint_dir(checkpoint_dir)

