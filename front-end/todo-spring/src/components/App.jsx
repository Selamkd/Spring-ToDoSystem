import '../styles/App.css';
import Header from './Header';
import InputForm from './InputForm';
import TaskList from './TasksList';
import { ThemeProvider } from './theme-provider.jsx';
function App() {
  return (
    <div className="flex flex-col h-screen">
      <section>
        <Header />
      </section>

      <section className="grid grid-cols-2 py-10 h-screen">
        <div className="flex flex-col p-4 justify-start items-start border border-purple-500">
          <InputForm />
        </div>
        <div className="flex flex-col items-end p-4 border border-purple-500">
          <TaskList />
        </div>
      </section>
    </div>
  );
}

export default App;
