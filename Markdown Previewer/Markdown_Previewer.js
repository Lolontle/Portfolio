import React from 'react';
import Badge from "react-bootstrap/Badge";
let marked = require("marked");

const defaultMarkdown = `# React Markdown Previewer

## Type your Markdown in the Editor!
<br><br>

### Main functionality

- Preview window updates real time with markdown syntax
- The editor has some predefined input on page load
- BONUS: Use &lt;br&gt; for line breaks

<br>

\`Is the syntax highlighting even working?\`
\`\`\`javascript
let s = "JavaScript syntax highlighting";
alert(s);
\`\`\`
<br>

> “I believe that every entrepreneur should be a passion-fuelled  optimist.”
― Gil Oved 
<br>

![react logo](https://i.postimg.cc/Bv9y8sBZ/react-logo.png)
<br>

Coded by **Lolontle Moatshe**, 2020 for [freeCodeCamp](https://www.freecodecamp.org) Front End Libraries Challenges
`;
class App extends React.Component{
  state = {
    text: defaultMarkdown
  }
  
  handleChange = (e) => {
    this.setState({
      text: e.target.value
    })
    
  }
  render(){
    const {text} = this.state;
    const markdown = marked(text, {breaks: true});
    return(
      <div>
        <h2 className="text-center m-4">Convert your Markdown</h2>
        <div className="row">
          <div className="col-6">
            <h5 className="text-center">Enter Your Markdown Here:</h5>
            <textarea className="form-control" id="editor" value={text} onChange={this.handleChange}/>
          </div>
          
           <div className="col-6 preview" >
             <h5 className="text-center">See your result:</h5>
             <div className="preview rounded" dangerouslySetInnerHTML={{__html: markdown}} id="preview">
              
               </div>
           </div>
          </div>
      </div>
    );
  }
}

ReactDOM.render(<App/>, document.getElementById('app'));