### Code Contribution
Code contribution can be done via pull requests.

Before any contribution, please check our (contribution guide){CONTRIBUTING.md}.
## Script generation
The script generation is done by a ZipOutStream. The following elements are written into this stream:
  - The simulation and scenarios code
  - The resource files (feeders and data)
  - The complementary files such as README and scripts.

### Simulation code
  The scala code contained in the zip file is created from an Abstract Syntax Tree (AST). This tree  embodies the simultation structure.
